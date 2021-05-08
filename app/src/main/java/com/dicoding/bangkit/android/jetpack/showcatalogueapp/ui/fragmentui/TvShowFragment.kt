package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.fragmentui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.Helper.TYPE_TVSHOW
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.databinding.FragmentTvShowBinding
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.Showtaiment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.activityui.DetailActivity
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.adapterui.DataCallback
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.adapterui.DataManagementAdapter
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.viewmodelui.MainViewModel
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.viewmodel.ViewModelFactory


class TvShowFragment : Fragment(), DataCallback {
    private lateinit var mainTvshoViewModel: MainViewModel
    private lateinit var binding: FragmentTvShowBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        activity.let {
//            mainTvshoViewModel = ViewModelProvider(
//                it!!,
//                ViewModelProvider.NewInstanceFactory()
//            )[MainViewModel::class.java]
//        }
        setupRecyclerView()
        activity.let {
            mainTvshoViewModel = ViewModelProvider(
                it!!,
                ViewModelFactory.getInstance()
            )[MainViewModel::class.java]
        }
        mainTvshoViewModel.getListTvShows().observe(viewLifecycleOwner, { listTvshow ->
            binding.rvTvshow.adapter.let { adapter ->
                when(adapter){
                    is DataManagementAdapter -> adapter.setData(listTvshow)
                }
            }
        })
//        val listTvShow = mainTvshoViewModel.getListTvShow()
//        setupRecyclerView(listTvShow)
    }

    private fun setupRecyclerView() {
        binding.rvTvshow.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DataManagementAdapter(this@TvShowFragment)
        }
    }
//    fun setupRecyclerView(data: List<Showtaiment>) {
//        binding.rvTvshow.apply {
//            layoutManager = LinearLayoutManager(context)
//            setHasFixedSize(true)
//            adapter = DataManagementAdapter(this@TvShowFragment)
//        }.also {
//            it.adapter.let { adapter ->
//                when (adapter) {
//                    is DataManagementAdapter -> adapter.setData(data)
//                }
//
//            }
//        }
//    }


    override fun onItemClicked(dataPojo: Showtaiment) {
//        val intent = Intent(context, DetailActivity::class.java)
//        intent.putExtra(DetailActivity.EXTRA_DATA,dataPojo.id)
//        intent.putExtra(DetailActivity.EXTRA_TYPE,Helper.TYPE_TVSHOW)
//        startActivity(intent)
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, dataPojo.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_TVSHOW)
        )
    }

}