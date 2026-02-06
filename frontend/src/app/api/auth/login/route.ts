import { NextResponse } from "next/server";

export async function POST(req: Request) {
  const body = await req.json();

  const res = await fetch("http://localhost:8080/auth/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(body),
  });

  if (!res.ok) {
    return NextResponse.json(
      { error: "Credenciais inválidas" },
      { status: 401 }
    );
  }

  const data = await res.json();

  const response = NextResponse.json(data);
  response.cookies.set("token", data.token, {
    httpOnly: true,
    path: "/",
    maxAge: 60 * 60 * 2,
  });

  return response;
}
