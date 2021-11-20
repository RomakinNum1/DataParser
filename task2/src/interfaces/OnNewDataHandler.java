package interfaces;

import java.io.IOException;

public interface OnNewDataHandler<T> {
    void OnNewData(Object sender, T e) throws IOException;
}