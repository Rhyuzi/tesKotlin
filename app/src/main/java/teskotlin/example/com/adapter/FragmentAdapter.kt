package teskotlin.example.com.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import teskotlin.example.com.ui.ChatFragment
import teskotlin.example.com.ui.ContactFragment
import teskotlin.example.com.ui.SettingFragment

class FragmentAdapter(fragmentAdapter: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentAdapter, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        if (position == 0){
            return ChatFragment()
        }else if(position == 1){
            return ContactFragment()
        }else{
            return SettingFragment()
        }
    }

}