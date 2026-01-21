export default function Home() {
  return (
    <main className="min-h-screen flex flex-col items-center justify-center bg-[#fcffea] px-4">
      <h1 className="text-4xl font-bold text-green-600">
        JadeDrive
      </h1>

      <p className="mt-4 text-center max-w-xl text-gray-600">
        Encontre instrutores de direção licenciados pelo DETRAN e
        agende suas aulas com segurança e praticidade.
      </p>

      <div className="mt-8 flex gap-4">
        <button className="px-6 py-3 bg-(--cor-primaria) text-white rounded-lg hover:bg-(--cor-secundaria) transition">
          Encontrar instrutor
        </button>

        <button className="px-6 py-3 border border-(--cor-primaria) text-(--cor-primaria) rounded-lg hover:bg-(--cor-terciaria) transition">
          Quero ser instrutor
        </button>
      </div>
    </main>
  );
}