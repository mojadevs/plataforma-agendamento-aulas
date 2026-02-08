import { NextResponse } from 'next/server'
import type { NextRequest } from 'next/server'

export function middleware(request: NextRequest) {
  const token = request.cookies.get('session_token')?.value
  const role = request.cookies.get('user_role')?.value
  const { pathname } = request.nextUrl

  // 1. Definimos as rotas que são SEMPRE públicas (mesmo dentro de /instrutor ou /aluno)
  const isPublicRoute = pathname.endsWith('/cadastro') || pathname === '/login' || pathname === '/'

  // 2. Se NÃO está logado e tenta acessar área restrita (que não seja pública)
  if (!token && !isPublicRoute && (pathname.startsWith('/marketplace') || pathname.startsWith('/instrutor'))) {
    return NextResponse.redirect(new URL('/login', request.url))
  }

  // 3. Se ESTÁ logado, mas tenta entrar no login ou cadastro (já tendo sessão)
  if (token && isPublicRoute && pathname !== '/') {
     const target = role === 'ALUNO' ? '/marketplace' : '/instrutor/dashboard'
     return NextResponse.redirect(new URL(target, request.url))
  }

  // 4. Proteções de Cargo (Role) - Mantendo a lógica anterior
  if (role === 'ALUNO' && pathname.startsWith('/instrutor') && !isPublicRoute) {
    return NextResponse.redirect(new URL('/marketplace', request.url))
  }

  if (role === 'INSTRUTOR' && pathname.startsWith('/marketplace')) {
    return NextResponse.redirect(new URL('/instrutor/dashboard', request.url))
  }

  return NextResponse.next()
}

export const config = {
  // Mantemos o matcher vigiando essas pastas
  matcher: ['/marketplace/:path*', '/instrutor/:path*', '/login', '/aluno/:path*'],
}