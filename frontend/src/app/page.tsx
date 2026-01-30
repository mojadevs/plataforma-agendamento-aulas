"use client";

import { useEffect, useState } from "react";
import Image from "next/image";

const slides = [
  {
    image: "/img-Jdrive-aluno.png",
    title: "Aprenda a dirigir com quem é qualificado",
    description:
      "Encontre instrutores de direção licenciados pelo DETRAN e agende suas aulas com segurança, praticidade e confiança.",
    buttonText: "Saiba mais",
    buttonLink: "/sobre",
  },
  {
    image: "/img-Jdrive-instrutor.jpg",
    title: "Transforme seu conhecimento em renda",
    description:
      "Cadastre-se como instrutor, encontre alunos perto de você e aumente sua renda com liberdade e segurança.",
    buttonText: "Seja um instrutor",
    buttonLink: "/instrutor",
  },
];

export default function Home() {
  const [current, setCurrent] = useState(0);
  const [mounted, setMounted] = useState(false);

  useEffect(() => {
    setMounted(true);

    const interval = setInterval(() => {
      setCurrent((prev) => (prev + 1) % slides.length);
    }, 6000);

    return () => clearInterval(interval);
  }, []);

  if (!mounted) return null;

  return (
    <main className="min-h-[calc(100vh-80px)] bg-(--cor-fundo-primaria) flex justify-center items-center px-6">
      <div className="w-full max-w-6xl bg-(--cor-fundo-secundaria) rounded-3xl shadow-[0_25px_60px_rgba(0,0,0,0.12)] p-10 flex gap-12">

        {/* BUSCA */}
        <div className="w-1/3 bg-(--cor-fundo-primaria) rounded-2xl p-8 flex flex-col gap-6 shadow-md">
          <h2 className="text-xl font-semibold text-gray-800">
            Encontre um instrutor
          </h2>

          <select className="px-4 py-3 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-(--cor-primaria)">
            <option>Selecione o estado</option>
            <option>São Paulo</option>
            <option>Rio de Janeiro</option>
            <option>Minas Gerais</option>
          </select>

          <input
            type="text"
            placeholder="Digite sua cidade"
            className="px-4 py-3 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-(--cor-primaria)"
          />

          <button className="bg-(--cor-primaria) text-white py-3 rounded-lg hover:bg-(--cor-secundaria) transition shadow-md">
            Buscar
          </button>
        </div>

        {/* HERO SLIDER */}
        <div className="w-2/3 relative h-105 rounded-3xl overflow-hidden shadow-[0_20px_40px_rgba(0,0,0,0.15)]">

          {/* SLIDES */}
          <div
            className="absolute inset-0 flex transition-transform duration-700 ease-in-out"
            style={{ transform: `translateX(-${current * 100}%)` }}
          >
            {slides.map((slide, index) => (
              <div key={index} className="relative w-full h-full shrink-0">
                <Image
                  src={slide.image}
                  alt={slide.title}
                  fill
                  className="object-cover"
                  priority={index === 0}
                />
                <div className="absolute inset-0 bg-black/50" />
              </div>
            ))}
          </div>

          {/* CONTEÚDO */}
          <div className="relative z-10 h-full flex flex-col items-center justify-center text-center px-12 gap-6">
            <h1 className="text-4xl font-bold text-white max-w-2xl">
              {slides[current].title}
            </h1>

            <p className="text-white/90 max-w-xl leading-relaxed">
              {slides[current].description}
            </p>

            <a
              href={slides[current].buttonLink}
              className="px-10 py-4 bg-(--cor-primaria) text-white rounded-xl hover:bg-(--cor-secundaria) transition font-medium shadow-lg"
            >
              {slides[current].buttonText}
            </a>
          </div>
        </div>
      </div>
    </main>
  );
}
