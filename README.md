# Tenant Management System

An Android app for landlords to record tenants, see total rent, and call tenants.

## Download

Latest APK: see **Releases** on the right of this page.

## Features

- Register and log in
- Dashboard with number of tenants and total rent
- Add tenants and view all tenants (saved with Room)
- Call a tenant, options menu and navigation drawer

## Architecture

- `ui/` Activities, Fragments and TenantViewModel (UI layer)
- `data/` Tenant, TenantDao, TenantDatabase, TenantRepository (data layer)
- Screens → TenantViewModel (LiveData) → TenantRepository → Room

## Team

| Stage              | Member          | Admission No. | Pull request                                                  |
| ------------------ |-----------------|---------------|---------------------------------------------------------------|
| 1 Lead             | Maxwel Kimtai   | 170011        | N/A                                                           |
| 2 ViewModel        | Faith Wairimu   | 189444        | https://github.com/MaxwelKimtai/TenantManagementSystem/pull/1 |
| 3 Room             | Maureen Mburuga | 187600        | https://github.com/MaxwelKimtai/TenantManagementSystem/pull/3 |
| 4 Screens          | Tamara Wesonga  | 190577        | https://github.com/MaxwelKimtai/TenantManagementSystem/pull/2 |
| 5 Data integration | Gathoni Wachira | 162895        | https://github.com/MaxwelKimtai/TenantManagementSystem/pull/4 |
| 6 Release          | Maxwel Kimtai   | 170011        | https://github.com/MaxwelKimtai/TenantManagementSystem/pull/5 |
