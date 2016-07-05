# MaterialDesignDialog

***Gradle Dependency***
  ```
  dependencies{
        compile 'ca.vickypatel.materialdesigndialog:materialdesigndialog:1.0.3'
  }
  ```
**Basic Dialog Example**

```java
  /** simple custom dialog */
  new MaterialDesignDialog.Builder(MainActivity.this)
          .title(title)
          .content(content)
          .positiveActionText(positiveActionText)
          .negativeActionText(negativeActionText)
          .onPositiveAction(new MaterialDesignDialog.OnActionListener() {
              @Override
              public void onClick() {
                  Toast.makeText(MainActivity.this, "OK clicked", Toast.LENGTH_LONG).show();
              }
          })
          .onNegativeAction(new MaterialDesignDialog.OnActionListener() {
              @Override
              public void onClick() {
                  Toast.makeText(MainActivity.this, "CANCEL clicked", Toast.LENGTH_LONG).show();
              }
          })
          .show();
  ```
