package fr.kalipso.valorsky.utils.json;


import java.io.File;
import java.util.function.Consumer;

public interface JsonPersist<T> {
  void set(T paramT);

  T get();

  void getAndUpdate(Consumer<T> paramConsumer);

  void delete();

  boolean isExist();

  File getFile();
}