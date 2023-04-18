package com.banco.demo.commons.libs.photo

import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.canhub.cropper.CropImage
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageView
import com.canhub.cropper.options
import com.banco.demo.ui.R
import com.banco.demo.ui.theme.NeutralDarkGreyWhite

@Composable
fun PhotoField(
    modifier: Modifier = Modifier,
    imageUri: Uri? = null,
    onImageUriChange: (Uri) -> Unit,
) {

    val context = LocalContext.current

    val customCropImageLauncher =
        rememberLauncherForActivityResult(contract = CropImageContract()) { result ->
            when {
                result.isSuccessful -> {
                    Log.v("CropImage-Result", result.bitmap.toString())
                    Log.v("CropImage-Result", context.let { result.getUriFilePath(it) }.toString())
//                    handleCropImageResult(result.uriContent.toString())
                    onImageUriChange(Uri.parse(result.uriContent.toString().replace("file:", "")))
                }
                result is CropImage.CancelledResult -> {
                    Log.v("CropImage-Result", "cropping image was cancelled by the user")
                }
                else -> {
                    Log.v("CropImage-Result", "cropping image failed")
                }
            }
        }

    Card(modifier = modifier,
        border = BorderStroke(2.dp, NeutralDarkGreyWhite),
        shape = CircleShape,
        backgroundColor = NeutralDarkGreyWhite,
        elevation = 0.dp
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            if (imageUri != null) {

                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center)
                        .clickable {
                            customCropImageLauncher.launch(
                                options {
                                    setImageSource(
                                        includeGallery = true,
                                        includeCamera = true,
                                    )
                                    // Normal Settings
                                    setScaleType(CropImageView.ScaleType.FIT_CENTER)
                                    setCropShape(CropImageView.CropShape.RECTANGLE)
                                    setGuidelines(CropImageView.Guidelines.ON_TOUCH)
                                    setAspectRatio(1, 1)
                                    setMaxZoom(4)
                                    setAutoZoomEnabled(true)
                                    setMultiTouchEnabled(true)
                                    setCenterMoveEnabled(true)
                                    setShowCropOverlay(true)
                                    setAllowFlipping(true)
                                    setSnapRadius(3f)
                                    setTouchRadius(48f)
                                    setInitialCropWindowPaddingRatio(0.1f)
                                    setBorderLineThickness(3f)
                                    setBorderLineColor(Color.argb(170, 255, 255, 255))
                                    setBorderCornerThickness(2f)
                                    setBorderCornerOffset(5f)
                                    setBorderCornerLength(14f)
                                    setBorderCornerColor(Color.WHITE)
                                    setGuidelinesThickness(1f)
                                    setGuidelinesColor(R.color.white)
                                    setBackgroundColor(Color.argb(119, 0, 0, 0))
                                    setMinCropWindowSize(24, 24)
                                    setMinCropResultSize(20, 20)
                                    setMaxCropResultSize(99999, 99999)
                                    setActivityTitle("")
                                    setActivityMenuIconColor(0)
                                    setOutputCompressFormat(Bitmap.CompressFormat.JPEG)
                                    setOutputCompressQuality(90)
                                    setRequestedSize(0, 0)
                                    setRequestedSize(0,
                                        0,
                                        CropImageView.RequestSizeOptions.RESIZE_INSIDE)
                                    setInitialCropWindowRectangle(null)
                                    setInitialRotation(0)
                                    setAllowCounterRotation(false)
                                    setFlipHorizontally(false)
                                    setFlipVertically(false)
                                    setCropMenuCropButtonTitle(null)
                                    setCropMenuCropButtonIcon(0)
                                    setAllowRotation(true)
                                    setNoOutputImage(false)
                                    setFixAspectRatio(false)
                                }
                            )
                        },

                    contentDescription = "UserImage",
                    contentScale = ContentScale.Crop,
                    painter = rememberAsyncImagePainter(model = imageUri)
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center),
                    contentDescription = "UserImage",
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.ic_image_profile)
                )
            }


            Image(
                painter = painterResource(id = R.drawable.ic_edit_profile_photo),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.Center)
                    .clickable {
                        customCropImageLauncher.launch(
                            options {
                                setImageSource(
                                    includeGallery = true,
                                    includeCamera = true,
                                )
                                // Normal Settings
                                setScaleType(CropImageView.ScaleType.FIT_CENTER)
                                setCropShape(CropImageView.CropShape.RECTANGLE)
                                setGuidelines(CropImageView.Guidelines.ON_TOUCH)
                                setAspectRatio(1, 1)
                                setMaxZoom(4)
                                setAutoZoomEnabled(true)
                                setMultiTouchEnabled(true)
                                setCenterMoveEnabled(true)
                                setShowCropOverlay(true)
                                setAllowFlipping(true)
                                setSnapRadius(3f)
                                setTouchRadius(48f)
                                setInitialCropWindowPaddingRatio(0.1f)
                                setBorderLineThickness(3f)
                                setBorderLineColor(Color.argb(170, 255, 255, 255))
                                setBorderCornerThickness(2f)
                                setBorderCornerOffset(5f)
                                setBorderCornerLength(14f)
                                setBorderCornerColor(Color.WHITE)
                                setGuidelinesThickness(1f)
                                setGuidelinesColor(R.color.white)
                                setBackgroundColor(Color.argb(119, 0, 0, 0))
                                setMinCropWindowSize(24, 24)
                                setMinCropResultSize(20, 20)
                                setMaxCropResultSize(99999, 99999)
                                setActivityTitle("")
                                setActivityMenuIconColor(0)
                                setOutputCompressFormat(Bitmap.CompressFormat.JPEG)
                                setOutputCompressQuality(90)
                                setRequestedSize(0, 0)
                                setRequestedSize(0,
                                    0,
                                    CropImageView.RequestSizeOptions.RESIZE_INSIDE)
                                setInitialCropWindowRectangle(null)
                                setInitialRotation(0)
                                setAllowCounterRotation(false)
                                setFlipHorizontally(false)
                                setFlipVertically(false)
                                setCropMenuCropButtonTitle(null)
                                setCropMenuCropButtonIcon(0)
                                setAllowRotation(true)
                                setNoOutputImage(false)
                                setFixAspectRatio(false)
                            }
                        )
                    },
            )
        }
    }

}