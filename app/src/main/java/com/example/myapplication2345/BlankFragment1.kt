package com.example.myapplication2345

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.myapplication2345.databinding.FragmentBlank1Binding
import retrofit2.Call
import retrofit2.Response

class BlankFragment1 : Fragment() {
  lateinit var binding: FragmentBlank1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentBlank1Binding.inflate(layoutInflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
initClicker()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initClicker() {

        with(binding){
            calculateBtn.setOnClickListener{
                LoveService().api.calculatePercentage(firstName = firstEd.text.toString(),
                    secondName = secondEd.text.toString()  ).enqueue(object:retrofit2.Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful){
                            setFragmentResult("key", bundleOf(
                                "first" to response.body()!!.firstName,
                                "second" to response.body()!!.secondName,
                            "percentage" to response.body()!!.percentage,
                            "result" to response.body()!!.result))
 findNavController().navigate(R.id.blankFragment2)


                     }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        android.util.Log.e("ololo", "onFailure: ${t.message} " )
                    }

                })
            }
        }

    }
}