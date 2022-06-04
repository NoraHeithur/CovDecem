package com.nora.covdecem.presentation.cases

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nora.covdecem.R
import com.nora.covdecem.databinding.FragmentCaseDataBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CaseDataFragment : Fragment() {

    private val viewModel: CaseDataViewModel by viewModel()
    private lateinit var binding: FragmentCaseDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_case_data,
            container,
            false
        )
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.caseViewModel = viewModel

        loadDailyData()

        setupRefreshButtons()

        binding.swipeContainer.let {
            it.setOnRefreshListener {
                onForceToRefresh()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.refresh_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.refresh_menu_btn -> {
                onSwipeActionRefreshing(forceUpdate)
                onForceToRefresh()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupRefreshButtons() {
        viewModel.apply {
            refreshData.observe(viewLifecycleOwner) { refresh ->
                if (refresh) {

                    refreshDailyData()

                    displayRefreshCompleteText()
                } else {
                    onSwipeActionRefreshing(refresh)
                }
            }
        }
    }

    private fun loadDailyData() {
        viewModel.getDailyDataFromCaching()
    }

    private fun refreshDailyData() {
        viewModel.getNewDailyDataFromSource()
    }

    private fun onForceToRefresh() {
        viewModel.onForceToUpdateData()
    }

    private fun onSwipeActionRefreshing(actionRefreshing: Boolean) {
        binding.swipeContainer.isRefreshing = actionRefreshing
    }

    private fun displayRefreshCompleteText() {
        Toast.makeText(
            requireContext(),
            R.string.notify_label_refresh_complete,
            Toast.LENGTH_SHORT
        ).show()
    }

    companion object {
        private const val forceUpdate = true
    }
}