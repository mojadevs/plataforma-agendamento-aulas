"use client";

import { useRouter } from "next/navigation";

export default function Marketplace() {
  const router = useRouter();

  const logout = async () => {
    await fetch("/api/auth/logout", {
      method: "POST",
    });

    router.push("/login");
  };

  return (
    <main className="mt-20">
      <h1>Marketplace</h1>
      <p>Bem-vindo 👋</p>

      <button onClick={logout}>Sair</button>
    </main>
  );
}
