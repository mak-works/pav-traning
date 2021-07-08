package com.learning.androidlearning.movemarker.kotlin.splash

import java.util.*

class GetCoreResponse {
    var message: String? = null
    val detail: Detail? = null
    val status = 0

    override fun toString(): String {
        return "ClassPojo [message = $message, detail = $detail, status = $status]"
    }

    class Detail {
        val reward_per_trip = 0
        val minimum_reward_request = 0
        val reward_kwd: String? = null
        val driver_image: String? = null
        val site_logo: String? = null
        val book_now_interval = 0
        val image_base: String? = null
        val model_details: ArrayList<ModelDetails>? = null
        val aboutpage_description: String? = null
        val app_name: String? = null
        val twitter_share: String? = null
        val noimage_base: String? = null
        val site_country: String? = null
        val site_currency: String? = null
        val airport_trip_interval = 0
        val book_later_interval = 0
        val child_account_types: ArrayList<String>? = null
        val share_content: String? = null
        val airport_pick_up = 0
        val sitead_image: String? = null
        val facebook_share: String? = null
        val customer_support: String? = null
        val repeat_trip_interval = 0
        val cancellation_setting: String? = null
        val recent_location: ArrayList<String>? = null
        val fav_icons: ArrayList<String>? = null
        val api_base: String? = null
        val site_currency_symbol: String? = null
        val facebook_key: String? = null
        val admin_email: String? = null
        val airport_drop = 0
        val skip_credit: String? = null
        val metric: String? = null
        private val default_country_code: String? = null
        val version_code = 0
        val version_name: String? = null
        val instagram_share: String? = null
        val asset_key: String? = null
        val int_key: String? = null
        val fareCalculationType = 0
        val airportTerminals: List<AirportTerminal>? = null
        val cancellation_reasons: ArrayList<CancellationReasons>? = null
        val drivers_unavailable_msg: String? = null
        val luxury_model_msg: String? = null
        val no_service_msg_title: String? = null
        val no_service_desc_Pickup: String? = null
        val no_service_desc_Drop: String? = null
        val is_mandatory_update = 0
    }

    class ModelDetails {
        val waiting_free: String? = null
        val model_size: String? = null
        val evening_timing_from: String? = null
        val evening_fare = 0
        val model_name: String? = null
        val base_mins = 0
        val model_image_unfocus: String? = null
        private val _id = 0
        val iconic_image_thumb: String? = null
        val evening_charge = 0
        val model_name_ar: String? = null
        val priority: String? = null
        val evening_timing_to: String? = null
        val model_image_confirmation: String? = null
        val min_fare = 0f
        val model_image: String? = null
        val model_image_unfocus_thumb: String? = null
        val model_image_2: String? = null
        val night_charge = 0
        val max_luggage = 0
        val night_timing_to: String? = null
        val base_fare: Float? = null
        val category_name: String? = null
        val model_id = 0
        val iconic_image: String? = null
        val model_image_new: String? = null
        val night_fare = 0
        val airport_pickup_fare = 0
        val airport_drop_fare = 0.0
        val waiting_cost_per_hour = 0f
        val night_timing_from: String? = null
        val min_km = 0f
        val below_above_km = 0f
        val below_km = 0f
        val above_km = 0f
        var per_minutes_fare: Float? = null
        var per_min_time = 0
        var bgmShapeResource = 0
        val hourly_fare_list: Map<Int, Double>? = null
        val model_image_fare: String? = null

        fun get_id(): Int {
            return _id
        }
    }

    class AirportTerminal {
        //"_id":1,"name":"Kuwait airport terminal 1",
        // "latitude":"29.2404","longitude":"47.9710"
        var name: String? = null
        var latitude: String? = null
        var longitude: String? = null
    }

    class CancellationReasons {
        var _id: String? = null
        var reason: String? = null
        var reason_ar: String? = null
    }
}
