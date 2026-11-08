package com.example.tenantmanagementsystem.ui.tenants


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.tenantmanagementsystem.data.repository.TenantRepository
import com.example.tenantmanagementsystem.databinding.FragmentViewTenantsBinding

class ViewTenantsFragment : Fragment() {

    // Holds the binding for this Fragment's layout
    private var _binding: FragmentViewTenantsBinding? = null

    // Provides safe access to the binding
    private val binding get() = _binding!!

    // Receives arguments passed through Safe Args
    private val args: ViewTenantsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the Data Binding layout
        _binding = FragmentViewTenantsBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        // Receive the tenant sent from AddTenantFragment
        val newTenant = args.newTenant

        // Pass the tenant object to the Data Binding layout
        binding.tenant = newTenant

        // Hide the newly added section if no tenant was passed
        if (newTenant == null) {
            binding.newTenantGroup.visibility = View.GONE
        }

        // Display all tenants stored in the repository
        val tenants = TenantRepository.tenants

        if (tenants.isEmpty()) {

            binding.allTenantsTextView.text =
                "No tenants yet. Add one from the Dashboard."

        } else {

            binding.allTenantsTextView.text =
                tenants.joinToString("\n\n") {
                    it.summary()
                }
        }

        // Open the phone dialer for the newly added tenant
        binding.callButton.setOnClickListener {

            if (newTenant != null) {

                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:${newTenant.phone}")
                )

                startActivity(intent)
            }
        }
    }

    // Release the binding when the Fragment's view is destroyed
    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}