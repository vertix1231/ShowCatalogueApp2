package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.fragmentui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.Helper
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.databinding.FragmentMovieBinding
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.Showtaiment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.activityui.DetailActivity
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.adapterui.DataCallback
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.adapterui.DataManagementAdapter
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.viewmodelui.MainViewModel
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.viewmodel.ViewModelFactory


class MovieFragment : Fragment(), DataCallback {

    private lateinit var mainMovieViewModel: MainViewModel
    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        activity.let {
//            mainMovieViewModel = ViewModelProvider(
//                it!!,
//                ViewModelProvider.NewInstanceFactory()
//            )[MainViewModel::class.java]
//        }
        setupRecyclerView()
        activity.let {
            mainMovieViewModel = ViewModelProvider(
                it!!,
                ViewModelFactory.getInstance()
            )[MainViewModel::class.java]
        }

        mainMovieViewModel.getListMovies().observe(viewLifecycleOwner, { lisMovie ->
            binding.rvMovie.adapter.let {adapter ->
            when(adapter){
                is DataManagementAdapter -> adapter.setData(lisMovie)
            }
            }
        })
//        val listmovie = mainMovieViewModel.getListMovie()
//        setupRecyclerView(listmovie)
    }

    private fun setupRecyclerView(){
        binding.rvMovie.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DataManagementAdapter(this@MovieFragment)
        }
    }

//    fun setupRecyclerView(data: List<Showtaiment>) {
//        binding.rvMovie.apply {
//            layoutManager = LinearLayoutManager(context)
//            setHasFixedSize(true)
//            adapter = DataManagementAdapter(this@MovieFragment)
//        }.also {
//            it.adapter.let { adapter ->
//                when (adapter) {
//                    is DataManagementAdapter -> adapter.setData(data)
//                }
//            }
//        }
//
//    }

    override fun onItemClicked(dataPojo: Showtaiment) {

        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, dataPojo.id)
                .putExtra(DetailActivity.EXTRA_TYPE, Helper.TYPE_MOVIE)
        )
    }
}