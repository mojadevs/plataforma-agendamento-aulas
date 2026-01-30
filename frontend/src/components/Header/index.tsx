import Link from "next/link";

export default function Header() {
  return (
    <header className="w-full bg-(--cor-primaria) shadow-md">
      <div className="max-w-7xl mx-auto px-6 py-4 flex items-center justify-between">
        
        {/* LOGO */}
        <Link
          href="/"
          className="text-2xl font-bold text-white hover:text-gray-300 transition"
        >
          JadeDrive
        </Link>

        {/* AÇÕES */}
        <nav className="flex gap-4">
          <Link
            href="/login"
            className="px-5 py-2 border border-white text-white rounded-full hover:bg-(--cor-secundaria) transition"
          >
            Login
          </Link>

          <Link
            href="/cadastrar"
            className="px-5 py-2 bg-white text-(--cor-primaria) rounded-full hover:bg-gray-300 transition"
          >
            Cadastrar
          </Link>
        </nav>

      </div>
    </header>
  );
}
