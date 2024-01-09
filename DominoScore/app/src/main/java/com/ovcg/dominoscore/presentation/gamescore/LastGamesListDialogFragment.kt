package com.ovcg.dominoscore.presentation.gamescore

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.ovcg.dominoscore.databinding.LastGamesListDialogFragmentBinding
import com.ovcg.dominoscore.databinding.StartFragmentBinding

/**
 * TODO: document your custom view class.
 */
class LastGamesListDialogFragment : DialogFragment() {

    private var _binding: LastGamesListDialogFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LastGamesListDialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}