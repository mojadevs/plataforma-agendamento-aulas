import Link from "next/link";
import styles from "./index.module.css";
import CadastroBox from "../cadastroBox";

export default function Header() {
  return (
    <header className={styles.header}>
      <div className={styles.container}>
        
        <Link href="/" className={styles.logo}>
          JadeDrive
        </Link>

        <nav className={styles.actions}>
          <Link href="/login" className={styles.login}>
            Login
          </Link>

          <CadastroBox />
        </nav>
      </div>
    </header>
  );
}
