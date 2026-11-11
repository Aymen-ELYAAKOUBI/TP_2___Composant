package com.example.tp_10___composant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class Exercice3Fragment : Fragment() {

    private val animals = arrayOf(
        "Lion",
        "Éléphant",
        "Girafe",
        "Tigre",
        "Panda",
        "Zèbre",
        "Kangourou",
        "Dauphin",
        "Aigle",
        "Ours"
    )

    private val animalDescriptions = mapOf(
        "Lion" to "Le Lion (Panthera leo) est une espèce de mammifères carnivores de la famille des Félidés. Surnommé 'Le Roi de la Savane'.",
        "Éléphant" to "L'Éléphant est le plus grand animal terrestre vivant. Il possède une trompe caractéristique et une mémoire remarquable.",
        "Girafe" to "La Girafe est la plus haute de toutes les espèces d'animaux terrestres. Son cou très long lui permet de manger les feuilles d'acacia.",
        "Tigre" to "Le Tigre est le plus grand de tous les félins. Il est reconnaissable à ses rayures noires sur pelage orange.",
        "Panda" to "Le Panda géant est un mammifère originaire de Chine centrale qui se nourrit principalement de bambou.",
        "Zèbre" to "Le Zèbre est un équidé aux rayures caractéristiques noires et blanches, vivant dans les savanes africaines.",
        "Kangourou" to "Le Kangourou est un marsupial d'Australie célèbre pour ses grands bonds et sa poche ventrale.",
        "Dauphin" to "Le Dauphin est un mammifère marin très intelligent, vivant en groupes et communiquant par écholocalisation.",
        "Aigle" to "L'Aigle est un grand oiseau de proie majestueux doté d'une vue perçante et de serres puissantes.",
        "Ours" to "L'Ours est un grand mammifère plantigrade, puissant et omnivore, présent dans divers habitats à travers le monde."
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercice3, container, false)
        val listView: ListView = view.findViewById(R.id.listViewAnimals)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            animals
        )

        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val animal = animals[position]
            val description = animalDescriptions[animal] ?: "Description non disponible."

            AlertDialog.Builder(requireContext())
                .setTitle("Détails : $animal")
                .setMessage(description)
                .setPositiveButton("Fermer") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        return view
    }
}
