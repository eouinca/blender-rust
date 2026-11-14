use jni::objects::JString;
use jni::sys::jstring;
use jni::JNIEnv;

#[no_mangle]
pub extern "system" fn Java_com_example_blenderrust_MainActivity_nativeGetStatus(
    mut env: JNIEnv,
    _this: jni::objects::JObject,
) -> jstring {
    let message = env
        .new_string("Blender-Rust engine: JNI connection OK")
        .expect("failed to create Java string");
    message.into_raw()
}

/// Простая общая структура ядра. Позже здесь появятся Mesh, Scene и математика.
#[derive(Clone, Copy, Debug, Default)]
pub struct Vec3 {
    pub x: f32,
    pub y: f32,
    pub z: f32,
}

impl Vec3 {
    pub const fn new(x: f32, y: f32, z: f32) -> Self {
        Self { x, y, z }
    }
}
