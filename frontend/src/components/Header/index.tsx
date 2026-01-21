import Link from "next/link";

export default function Header() {
  return (
    <header className="w-full bg-(--cor-fundo-secundaria) border-b border-gray-300 shadow-dm">
      <div className="max-w-7xl mx-auto px-6 py-4 flex items-center justify-between">
        <Link href="/" className="text-2xl font-bold text-(--cor-primaria) hover:text-(--cor-secundaria) transition">
            JadeDrive
          </Link>
        <nav className="flex gap-6">
          <Link href="/login" className="px-4 py-2 border border-(--cor-primaria) text-(--cor-primaria) rounded-full shadow-md hover:bg-(--cor-terciaria) transition">
            Entrar
          </Link>

          <Link href="/cadastrar" className="px-4 py-2 bg-(--cor-primaria) text-white rounded-full shadow-md hover:bg-(--cor-secundaria) transition">
            Cadastre-se
          </Link>
        </nav>
      </div>
    </header>
  );
}
