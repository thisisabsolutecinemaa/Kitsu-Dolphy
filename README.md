# Kitsu-Dolphy

Данный проект является форком Dolphy с ребрендингом в `Kitsu-Dolphy`, красной Material 3 темой и фундаментом для IR, BLUETOOTH HID, LAN scanning, TV cast и plugin manager.

## Что уже сделано
- переименование приложения
- красная тема без dynamic color
- пример парсинга `.ir` из Flatpipper/Flipper-IRDB
- базовые классы для HID, LAN, TV cast, plugin manager
- пример IR ассета

## Сборка
```bash
./gradlew assembleDebug
```

## Основные пути
- `app/src/main/java/com/kitsu/dolphy/MainActivity.kt`
- `app/src/main/java/com/kitsu/dolphy/ui/theme/Theme.kt`
- `app/src/main/java/com/kitsu/dolphy/ir/IrRepository.kt`
- `app/src/main/java/com/kitsu/dolphy/hid/KeyboardService.kt`
- `app/src/main/java/com/kitsu/dolphy/network/LanScanner.kt`
- `app/src/main/java/com/kitsu/dolphy/tvcast/SmartTvCast.kt`
- `app/src/main/java/com/kitsu/dolphy/plugin/PluginManager.kt`
