package com.mobjoy.routetask.products.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobjoy.domain.model.products.ProductsItem
import com.mobjoy.routetask.databinding.ProductItemLayoutBinding
import java.math.BigDecimal
import java.math.RoundingMode

class ProductsAdapter(var list: List<ProductsItem?>) :
    RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    class MyViewHolder(val viewBinding: ProductItemLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ProductItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyViewHolder(view)
    }

    fun bindProductsList(list: List<ProductsItem?>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        val prevPrice = item?.price.toString()
        val discount = item?.discountPercentage.toString()
        holder.viewBinding.productTitleTV.text = item?.title.toString()
        holder.viewBinding.productDescrTV.text = item?.description.toString()
        holder.viewBinding.productPriceTV.text = "EGP ${calculateDiscount(prevPrice, discount)}"
        holder.viewBinding.productPrevPriceTV.text = "EGP ${item?.price.toString()}"
        holder.viewBinding.productRatingTV.text = "Review (${item?.rating.toString()})"

        Glide.with(holder.itemView)
            .load(item?.thumbnail)
            .into(holder.viewBinding.productImg)

    }

    private fun calculateDiscount(prevPrice: String, discount: String): String {
        val totalMoneyDiscount = (prevPrice.toDouble() * (discount.toDouble()) / 100)
        val totalAfterDiscount = (prevPrice.toFloat() - totalMoneyDiscount)
        val decimal = BigDecimal(totalAfterDiscount).setScale(2, RoundingMode.HALF_EVEN)
        return decimal.toString()
    }
}