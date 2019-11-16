package com.kang6264.githubsearchuser.utils


import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

@BindingAdapter("url")
fun SetProfile(simpleDraweeView: SimpleDraweeView, url: String) {
    simpleDraweeView.setImageURI(url)
}
