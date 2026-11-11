package com.example.tp_10___composant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemListFragment : Fragment() {

    private val fruits = listOf(
        Fruit("Pomme", "Fruit à pépins", "Riche en fibres et en vitamine C, la pomme est l'un des fruits les plus populaires.", "🍎"),
        Fruit("Banane", "Fruit tropical", "Source d'énergie et de potassium, idéale pour les sportifs et le petit-déjeuner.", "🍌"),
        Fruit("Orange", "Agrume", "Riche en vitamine C et en antioxydants, parfaite pour les jus frais.", "🍊"),
        Fruit("Fraise", "Fruit rouge", "Délicieusement sucrée et parfumée, riche en antioxydants et faible en calories.", "🍓"),
        Fruit("Ananas", "Fruit tropical", "Contient de la bromélaïne, une enzyme favorisant la digestion.", "🍍"),
        Fruit("Mangue", "Fruit exotique", "Chair douce, juteuse et très riche en vitamines A et C.", "🥭"),
        Fruit("Raisin", "Fruit à baies", "Excellente source de resvératrol et d'antioxydants pour le cœur.", "🍇"),
        Fruit("Kiwi", "Agrume exotique", "Contient plus de vitamine C qu'une orange et beaucoup de fibres.", "🥝"),
        Fruit("Pastèque", "Cucurbitacée", "Très désaltérante, composée à 92% d'eau et très rafraîchissante.", "🍉"),
        Fruit("Pêche", "Fruit à noyau", "Douce, parfumée et veloutée, parfaite pour l'été.", "🍑")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewFruits)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = FruitAdapter(fruits) { fruit ->
            AlertDialog.Builder(requireContext())
                .setTitle("${fruit.emoji} ${fruit.name}")
                .setMessage("Catégorie : ${fruit.category}\n\n${fruit.description}")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        recyclerView.adapter = adapter

        return view
    }
}
