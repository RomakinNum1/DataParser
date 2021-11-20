package resources;

import interfaces.OnCompleted;

public class Completed implements OnCompleted
{
    public void OnCompleted(Object sender) {
        System.out.println("Загрузка закончена");
    }
}

