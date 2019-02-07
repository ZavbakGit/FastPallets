package `fun`.gladkikh.fastpallets.ui.adapters

import `fun`.gladkikh.fastpallets.R
import `fun`.gladkikh.fastpallets.mvp.model.EnumMenu
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


/**
 * Created by Alex on 16.06.2017.
 */

class ListMenuAdapter(private val mContext: FragmentActivity?, val mlist: List<EnumMenu>) : BaseAdapter() {

    override fun getCount() = mlist.size

    override fun getItem(position: Int) = mlist[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = mContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.item_commands, parent, false)
            viewHolder = ViewHolder(convertView)

            convertView!!.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        viewHolder.setData(Integer.toString(position + 1), mlist[position])

        return convertView
    }

    internal class ViewHolder(view: View) {
        var tvId: TextView = view.findViewById(R.id.tvId)
        var tvName: TextView = view.findViewById(R.id.tvName)



        fun setData(id: String, itemMenu: EnumMenu) {
            tvId.text = itemMenu.id.toString()
            tvName.text = itemMenu.fullName
        }
    }

}
