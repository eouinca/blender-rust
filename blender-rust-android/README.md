# Blender-Rust Android starter

Это стартовый проект для разработки 3D-редактора с общим ядром на Rust и Android-приложением на Kotlin.

Важно: это не порт Blender и пока не 3D-редактор. Сейчас проект проверяет связку Android UI → JNI → Rust. Далее в Rust будет развиваться геометрия, сцена, камера и рендеринг.

## Структура

- `rust/` — библиотека Rust (`cdylib`), вызываемая из Android через JNI.
- `android/` — Android-приложение на Kotlin и Gradle.

## Что понадобится

- Rust stable
- Android Studio и Android SDK
- Android NDK и CMake (через SDK Manager)
- `cargo-ndk`: `cargo install cargo-ndk`
- Android target для Rust, например:
  ```bash
  rustup target add aarch64-linux-android
  ```

## Сборка Rust-библиотеки для Android

Из корня проекта:

```bash
cd rust
cargo ndk -t arm64-v8a -o ../android/app/src/main/jniLibs build --release
```

Для эмулятора x86_64 можно дополнительно установить target:
`rustup target add x86_64-linux-android`, затем выполнить:

```bash
cargo ndk -t x86_64 -o ../android/app/src/main/jniLibs build --release
```

## Открыть Android-приложение

Открой папку `android/` в Android Studio и дождись синхронизации Gradle. После сборки запусти приложение на устройстве или эмуляторе.

Если Android Studio попросит указать SDK или JDK, установи рекомендуемые версии через Android Studio.

## Текущий JNI-мост

Kotlin вызывает `nativeGetStatus()`, Rust возвращает строку о состоянии ядра. Это минимальный тест, что нативная библиотека загружается и вызывается.

## Следующие этапы

1. Общие структуры `Vec3`, `Transform`, `Mesh`, `Scene` в Rust.
2. Передача данных сцены из Rust в Android.
3. 3D viewport на Android (начать с OpenGL ES).
4. Управление камерой жестами: вращение, панорамирование, масштаб.
5. Создание и трансформация объектов.
6. Импорт/экспорт OBJ и затем GLTF.

Пока Android-приложение — оболочка для будущего редактора; полноценного viewport ещё нет.
