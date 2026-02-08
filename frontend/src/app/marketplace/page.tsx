import styles from './marketplace.module.css'

export default function MarketplacePage() {
  const instrutores = [
    { id: 1, nome: 'Carlos Silva', telefone: '(11) 99999-9999', preco: 60.00 },
    { id: 2, nome: 'Ana Pereira', telefone: '(11) 98888-8888', preco: 75.50 },
    { id: 3, nome: 'Roberto Alves', telefone: '(21) 97777-7777', preco: 55.00 },
  ]

  return (
    <main className={styles.main}>
      <div className={styles.container}>
        
        <header className={styles.header}>
          <div>
            <h1 className={styles.welcomeTitle}>Marketplace de Instrutores</h1>
            <p className={styles.cardInfo}>Encontre o melhor profissional para você</p>
          </div>
        </header>

        <div className={styles.grid}>
          {instrutores.map((instrutor) => (
            <div key={instrutor.id} className={styles.card}>
              <h2 className={styles.cardTitle}>{instrutor.nome}</h2>
              
              <div className={styles.cardInfo}>
                <span>📱</span> {instrutor.telefone}
              </div>
              
              <div className={styles.priceTag}>
                <span>R$ {instrutor.preco.toFixed(2)} /h</span>
                <button className={styles.actionButton}>Ver Detalhes</button>
              </div>
            </div>
          ))}
        </div>

      </div>
    </main>
  )
}