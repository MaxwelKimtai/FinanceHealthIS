package com.example.tenantmanagementsystem.ui.dashboard

import android.util.Log
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystem.data.repository.TenantRepository
import com.example.tenantmanagementsystem.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(
            inflater,
            container,
            false
        )

        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onCreateView")

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onViewCreated")

        // Display total number of tenants
        binding.tenantCountTextView.text =
            "Total Tenants: ${TenantRepository.tenants.size}"

        // Display total monthly rent
        binding.totalRentTextView.text =
            "Total Monthly Rent: KSh ${TenantRepository.totalRent()}"

        // Navigate to Add Tenant screen
        binding.addTenantButton.setOnClickListener {

            val action = DashboardFragmentDirections
                .actionDashboardFragmentToAddTenantFragment()

            findNavController().navigate(action)
        }

       // Navigate to View Tenants screen
        binding.viewTenantsButton.setOnClickListener {

            val action = DashboardFragmentDirections
                .actionDashboardFragmentToViewTenantsFragment()

            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onDestroyView")

        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onDestroy")
    }
}