# Room Persistence Library
Simple data persistence using Room Persistence Library  

This simple project shows the use of the [Room Persistence Library](https://developer.android.com/topic/libraries/architecture/room)

![img](https://codelabs.developers.google.com/codelabs/android-room-with-a-view/img/a7da8f5ea91bac52.png)


### Useful Codelabs
[Android Room with a View](https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0)  
[LiveData observable data holder class](https://developer.android.com/topic/libraries/architecture/livedata.html)  
[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel.html)


### Final result

``` Java
 public class MainActivity extends AppCompatActivity {
     private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        User user = new User("Marcelino", "Matias");
        userViewModel.insert(user);

        userViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for(User user: users) {
                    System.out.println(user.firstName + " " + user.lastName);
                }
            }
        });
        
    }
}
```
