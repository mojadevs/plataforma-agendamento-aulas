"use client";

import { useState } from "react";
import { useRouter } from "next/navigation";
import styles from "./cadastro.module.css";

export default function Cadastro() {
  const router = useRouter();

  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [telefone, setTelefone] = useState("");
  const [senha, setSenha] = useState("");
  const [erro, setErro] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e: React.SyntheticEvent) => {
    e.preventDefault();
    setErro("");
    setLoading(true);

    try {
      // 1️⃣ CADASTRA ALUNO
      const cadastroRes = await fetch("/api/alunos", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          nome,
          email,
          telefone,
          senha,
          ativo: true,
        }),
      });

      if (!cadastroRes.ok) {
        throw new Error("Erro ao cadastrar");
      }

      // 2️⃣ LOGIN AUTOMÁTICO
      const loginRes = await fetch("/api/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
       body: JSON.stringify({
        email,
        senha,
      }),
      });
      const data = await loginRes.json()
      if (!loginRes.ok) {
        throw new Error("Erro ao autenticar");
      }

      // 3️⃣ SALVA TOKEN
      document.cookie = `token=${data.token}; path=/; SameSite=Lax`;

      // 4️⃣ REDIRECIONA
      router.push("/marketplace");
    } catch (err) {
      setErro("Erro ao cadastrar. Verifique os dados.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <main className={styles.main}>
      <div className={styles.card}>
        <h1 className={styles.title}>Cadastro de Aluno</h1>
        <p className={styles.subtitle}>
          Preencha os dados para criar sua conta
        </p>

        <form className={styles.form} onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="Nome completo"
            className={styles.input}
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            required
          />

          <input
            type="email"
            placeholder="Email"
            className={styles.input}
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />

          <input
            type="text"
            placeholder="Telefone"
            className={styles.input}
            value={telefone}
            onChange={(e) => setTelefone(e.target.value)}
            required
          />

          <input
            type="password"
            placeholder="Senha"
            className={styles.input}
            value={senha}
            onChange={(e) => setSenha(e.target.value)}
            required
          />

          {erro && <p className={styles.errorText}>{erro}</p>}

          <button className={styles.button} disabled={loading}>
            {loading ? "Cadastrando..." : "Cadastrar"}
          </button>
        </form>
      </div>
    </main>
  );
}
