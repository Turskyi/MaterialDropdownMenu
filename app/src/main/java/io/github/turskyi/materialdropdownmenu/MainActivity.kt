package io.github.turskyi.materialdropdownmenu

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    companion object {
        val COUNTRIES = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initListeners()
    }

    private fun initListeners() {

        filledExposedDropdown.setOnClickListener {
            if (filledExposedDropdown.isPopupShowing) {
                filledExposedDropdown.setBackgroundResource(R.drawable.bg_stroke_blue_round_top_corners)
            } else {
                filledExposedDropdown.setBackgroundResource(R.drawable.bg_stroke_blue)
            }
        }

        filledExposedDropdown.setOnItemClickListener { _, _, _, _ ->
            filledExposedDropdown.setBackgroundResource(R.drawable.bg_stroke_blue)
        }

        filledExposedDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                filledExposedDropdown.setBackgroundResource(R.drawable.bg_stroke_blue)

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int,
                id: Long
            ) {

            }
        }


    }

    private fun initView() {
        filledExposedDropdown.setBackgroundResource(R.drawable.bg_stroke_blue)
        filledExposedDropdown.setText("Item 1", false)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            R.layout.item_dropdown_menu_popup,
            COUNTRIES
        )

        filledExposedDropdown.setAdapter(adapter)
    }
}