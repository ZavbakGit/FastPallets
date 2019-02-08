package `fun`.gladkikh.fastpallets.ui.fragments

import `fun`.gladkikh.fastpallets.mvp.presenters.BasePresenter
import `fun`.gladkikh.fastpallets.navigate.BackButtonListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.MvpView
import ru.terrakok.cicerone.Router
import java.io.Serializable

open abstract class BaseScreenFragment : MvpAppCompatFragment(), BackButtonListener {

    companion object {
        fun newInstance(fragment:BaseScreenFragment,key:String,value:Serializable?): Any{
            val args: Bundle = Bundle()
            args.putSerializable(key, value)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(getLayout(), container, false)
        return view
    }

    override fun onBackPressed(): Boolean {
       return getPresenter().onBackPressed()
    }

    abstract fun getRouter():Router
    abstract fun getLayout(): Int
    abstract fun getPresenter(): BasePresenter<MvpView>
}