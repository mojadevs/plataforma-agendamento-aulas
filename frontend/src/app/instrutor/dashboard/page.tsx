import { logout } from '@/app/actions/auth'
import styles from './dashboard.module.css'

export default function InstrutorDashboard() {
  return (
    <main className={styles.main}>
      <div className={styles.container}>
        
        <header className={styles.header}>
          <div>
            <h1 className={styles.title}>Painel do Instrutor</h1>
            <p className={styles.subtitle}>Gerencie suas aulas e perfil</p>
          </div>
          <form action={logout}>
            <button type="submit" className={styles.logoutButton}>Sair</button>
          </form>
        </header>

        <section className={styles.grid}>
          <div className={styles.card}>
            <h2 className={styles.cardTitle}>Bem-vindo!</h2>
            <p className={styles.cardText}>
              Aqui você poderá visualizar seus alunos e atualizar seus dados de contato.
            </p>
          </div>

          <div className={styles.card}>
            <h2 className={styles.cardTitle}>Seu Perfil</h2>
            <p className={styles.cardText}>
              Lembre-se de manter seu telefone e preço/hora atualizados para atrair mais alunos.
            </p>
            <button className={styles.actionButton}>Editar Perfil</button>
          </div>
        </section>

      </div>
    </main>
  )
}