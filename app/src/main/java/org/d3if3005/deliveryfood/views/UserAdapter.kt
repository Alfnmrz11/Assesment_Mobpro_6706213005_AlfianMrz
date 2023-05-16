package org.d3if3005.deliveryfood.views

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.d3if3005.deliveryfood.R
import org.d3if3005.deliveryfood.data.model.UserData

class UserAdapter(val c: Context, val userList: ArrayList<UserData>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(val v: View) : RecyclerView.ViewHolder(v) {

        var name: TextView
        var mbNum: TextView
        var moreMenu: ImageView

        init {
            name = v.findViewById<TextView>(R.id.titleNewRecipe)
            mbNum = v.findViewById<TextView>(R.id.subTitleNewRecipe)
            moreMenu = v.findViewById(R.id.moreMenu)
            moreMenu.setOnClickListener { popupMoreMenu(it) }
        }

        private fun popupMoreMenu(v: View) {
            val position = userList[adapterPosition]
            val popupMoreMenu = PopupMenu(c, v)
            popupMoreMenu.inflate(R.menu.show_menu)
            popupMoreMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.editRecipe -> {
                        val v = LayoutInflater.from(c)
                            .inflate(R.layout.activity_add_item_new_recipe, null)
                        val title = v.findViewById<EditText>(R.id.titleNewRecipe)
                        val instruction = v.findViewById<EditText>(R.id.instructionNewRecipe)
                        val ingredient = v.findViewById<EditText>(R.id.ingredientNewRecipe)
                        AlertDialog.Builder(c)
                            .setView(v)
                            .setPositiveButton("Ok") { _, _ ->
                                position.title = title.text.toString()
                                position.instruction = instruction.text.toString()
                                position.ingredient = ingredient.text.toString()

                                notifyDataSetChanged()
                                Toast.makeText(c, "New Recipe Edited", Toast.LENGTH_SHORT).show()

                                // Kodingan edit
                            }
                            .setNegativeButton("Cancel") { _, _ ->
                                // biarin
                            }
                            .create()
                            .show()
                        true
                    }
                    R.id.deleteRecipe -> {
                        AlertDialog.Builder(c)
                            .setTitle("Delete")
                            .setIcon(R.drawable.ic_warning_sign)
                            .setMessage("Do You Want Delete This Recipe?")
                            .setPositiveButton("Yes") { dialog, _ ->
                                userList.removeAt(adapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(c, "Delete This Recipe", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("No") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .create()
                            .show()
                        true
                    }
                    else -> true
                }
            }
            popupMoreMenu.show()

            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMoreMenu)
            menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(menu, true)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item_new_recipe, parent, false)
        return UserViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList = userList[position]
        holder.name.text = newList.title
        holder.mbNum.text = newList.instruction
    }
}