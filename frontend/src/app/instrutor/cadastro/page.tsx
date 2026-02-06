"use client";

import styles from "./cadastro.module.css";

export default function Cadastro() {
  function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    // aqui depois você conecta com o backend
  }

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
          />

          <input
            type="email"
            placeholder="Email"
            className={styles.input}
          />

          <input
            type="password"
            placeholder="Senha"
            className={styles.input}
          />

          <button type="submit" className={styles.button}>
            Cadastrar
          </button>
        </form>
      </div>
    </main>
  );
}
