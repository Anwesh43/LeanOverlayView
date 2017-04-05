## LeanOverlayGallery

### Android library to add a overlay gallery in your app

### Usage

#### In app/build.gradle

```
    dependencies {
        compile project(':overlaygallery')
    }
```

#### In Activity file

```
    List bitmaps = new ArrayList<Bitmap>(); //create a list of bitmaps
    bitmaps.add(bitmap); // Add bitmap in bitmaps list
    OverlayGallery overlayGallery = new OverlayGallery(this,bitmaps); //create overlayGallery and pass activity object and list of bitmaps
    overlayGallery.show();
```

### Screencast of demo

<img src="https://github.com/Anwesh43/LeanOverlayView/blob/master/screencast/overlaygallery.gif" width="400px" height="700px" alt="screencast of demo">
