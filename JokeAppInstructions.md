# Code snippets and instructions to build an android app

### Create a project in Android Studio

### Copy the code in activity_main.xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@android:color/holo_orange_light"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/image"
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:contentDescription="@string/epic_face"
        android:src="@drawable/epic_face"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@android:color/holo_green_light"
        android:padding="20dp"
        android:text="@string/tell_me_a_joke"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/image" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:gravity="center"
        android:textSize="20sp"
        android:layout_margin="20dp"
        android:textColor="@android:color/black"
        android:fontFamily="casual"
        android:textStyle="bold"
        tools:text="Joke will be here."
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

### Strings used in the layout

```
<string name="joke_lost">Joke lost! Try again.</string>
<string name="tell_me_a_joke">tell me a joke</string>
<string name="epic_face">epic_face</string>
```

### Image used  in the layout

![Epic face image](https://user-images.githubusercontent.com/12607939/74732725-c5ea3080-5242-11ea-9c70-9172ea773726.png)

### Now if you run the app, it will display the UI but there is no backend to do the intended work

### 