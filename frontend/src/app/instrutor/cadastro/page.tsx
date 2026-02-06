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
  const [precoHora, setPrecoHora] = useState("");
  const [erro, setErro] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e: React.SyntheticEvent) => {
    e.preventDefault();
    setErro("");
    setLoading(true);

    try {
      // 1️⃣ cadastra aluno
      const cadastroRes = await fetch("/api/instrutores", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          nome,
          email,
          senha,
          telefone,
          precoHora: Number(precoHora),
          ativo: true,
        }),
      });
      const data=await cadastroRes.json();
      if (!cadastroRes.ok) {
  const err = await cadastroRes.text();
  console.error("Erro cadastro:", err);
  throw new Error(err);
}

      document.cookie = `token=${data.token}; path=/; max-age=7200`;

      // 4️⃣ redireciona
      router.push("/marketplace");
    } catch {
      setErro("Erro ao cadastrar instrutor");
    } finally {
      setLoading(false);
    }
  };

  return (
    <main className={styles.main}>
      <div className={styles.card}>
        <h1 className={styles.title}>Cadastro de Instrutor</h1>

        <form className={styles.form} onSubmit={handleSubmit}>
          <input
            className={styles.input}
            placeholder="Nome completo"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            required
          />

          <input
            className={styles.input}
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />

          <input
            className={styles.input}
            type="password"
            placeholder="Senha"
            value={senha}
            onChange={(e) => setSenha(e.target.value)}
            required
          />

          <input
            className={styles.input}
            placeholder="Telefone"
            value={telefone}
            onChange={(e) => setTelefone(e.target.value)}
            required
          />

          <input
            className={styles.input}
            type="number"
            placeholder="Preço por hora"
            value={precoHora}
            onChange={(e) => setPrecoHora(e.target.value)}
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
