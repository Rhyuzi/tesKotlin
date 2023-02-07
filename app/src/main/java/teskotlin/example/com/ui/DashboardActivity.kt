package teskotlin.example.com.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.widget.Adapter
import android.widget.TableLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.Tab
import org.intellij.lang.annotations.JdkConstants.TitledBorderTitlePosition
import teskotlin.example.com.R
import teskotlin.example.com.adapter.FragmentAdapter

class DashboardActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager2)

        adapter = FragmentAdapter(supportFragmentManager , lifecycle)

        tabLayout.addTab(tabLayout.newTab().setText("chat"))
        tabLayout.addTab(tabLayout.newTab().setText("contact"))
        tabLayout.addTab(tabLayout.newTab().setText("setting"))

        viewPager2.adapter = adapter

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener{
          override fun onTabSelected(tab: TabLayout.Tab?){
              if (tab != null){
                    viewPager2.currentItem = tab.position
              }
          }

            override fun onTabUnselected(tab: Tab?) {

            }

            override fun onTabReselected(tab: Tab?) {

            }
        })

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int){
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }

}


