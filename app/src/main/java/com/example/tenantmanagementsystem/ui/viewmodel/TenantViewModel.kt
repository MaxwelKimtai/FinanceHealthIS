package com.example.tenantmanagementsystem.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.tenantmanagementsystem.data.model.Tenant
import com.example.tenantmanagementsystem.data.repository.TenantRepository

// A Jetpack ViewModel: Android keeps it alive while the screen rotates,
// and clears it when MainActivity finishes
class TenantViewModel : ViewModel() {

    // 1. THE DATA
    // Only this ViewModel can change the tenant list
    private val _tenants = MutableLiveData<List<Tenant>>(
        TenantRepository.tenants.toList()
    )

    // Screens can observe this list, but cannot change it
    val tenants: LiveData<List<Tenant>> = _tenants

    // 2. TRANSFORMATIONS: text ready for the screens

    val tenantCountText: LiveData<String> = tenants.map { list ->
        "Tenants\n${list.size}"
    }

    val totalRentText: LiveData<String> = tenants.map { list ->
        val total = list.sumOf { it.rent.toDoubleOrNull() ?: 0.0 }
        "Total rent\nKSh %,.0f".format(total)
    }

    val allTenantsText: LiveData<String> = tenants.map { list ->
        if (list.isEmpty()) {
            "No tenants yet. Add one from the Dashboard."
        } else {
            list.joinToString("\n\n") { it.summary() }
        }
    }

    // 3. ACTIONS the screens can ask for

    fun addTenant(name: String, phone: String, rent: String): Tenant? {
        val cleanName = name.trim()
        val cleanPhone = phone.trim()
        val cleanRent = rent.trim()

        // All three fields are required
        if (cleanName.isEmpty() || cleanPhone.isEmpty() || cleanRent.isEmpty()) {
            return null
        }

        val tenant = Tenant(cleanName, cleanPhone, cleanRent)

        // Ask the data layer to store the tenant
        TenantRepository.addTenant(tenant)

        // Notify every observer that the list has changed
        _tenants.value = TenantRepository.tenants.toList()

        return tenant
    }

    // 4. LIFECYCLE LOGS

    init {
        Log.d("TENANT_LIFECYCLE", "TenantViewModel: created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TENANT_LIFECYCLE", "TenantViewModel: onCleared")
    }
}
