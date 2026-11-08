package com.example.tenantmanagementsystem.data.repository

import com.example.tenantmanagementsystem.data.model.Tenant

object TenantRepository {

    // Stores all tenant records
    val tenants = mutableListOf<Tenant>()

    // Adds a tenant to the collection
    fun addTenant(tenant: Tenant) {
        tenants.add(tenant)
    }

    // Calculates the total monthly rent
    fun totalRent(): Double {
        return tenants.sumOf {
            it.rent.toDoubleOrNull() ?: 0.0
        }
    }
}