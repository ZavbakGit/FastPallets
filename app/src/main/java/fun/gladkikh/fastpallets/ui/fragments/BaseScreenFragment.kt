package `fun`.gladkikh.fastpallets.ui.fragments

import `fun`.gladkikh.fastpallets.navigate.BackButtonListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import ru.terrakok.cicerone.Router

open abstract class BaseScreenFragment : MvpAppCompatFragment(), BackButtonListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view = inflater!!.inflate(getLayout(), container, false)
        return view
    }


    abstract fun getRouter():Router
    abstract fun getLayout(): Int
}