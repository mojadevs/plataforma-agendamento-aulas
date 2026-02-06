"use client";

import { useState } from "react";
import styles from "./cadastro.module.css";

export default function Cadastro() {
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
      const res = await fetch("/api/alunos", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          nome,
          email,
          telefone,
          senha,
          ativo: true, // exigido pelo DTO
        }),
      });

      if (!res.ok) {
        throw new Error("Erro ao cadastrar aluno");
      }

      alert("Aluno cadastrado com sucesso!");

      // limpa o formulário
      setNome("");
      setEmail("");
      setTelefone("");
      setSenha("");
    } catch (err) {
      setErro("Erro ao cadastrar aluno. Verifique os dados.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <main className={styles.main}>
      <div className={styles.card}>
        <h1 className={styles.title}>Cadastro</h1>
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

          <button
            type="submit"
            className={styles.button}
            disabled={loading}
          >
            {loading ? "Cadastrando..." : "Cadastrar"}
          </button>
        </form>
      </div>
    </main>
  );
}
