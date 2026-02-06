import { NextResponse } from "next/server";

export async function POST(req: Request) {
  const body = await req.json();

  const response = await fetch("http://localhost:8080/alunos/", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(body),
  });

  if (!response.ok) {
    return NextResponse.json(
      { error: "Erro ao cadastrar aluno" },
      { status: 500 }
    );
  }

  const data = await response.json();
  return NextResponse.json(data, { status: 201 });
}