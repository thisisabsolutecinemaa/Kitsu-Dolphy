# Kitsu-Dolphy

Это форк Dolphy с ребрендингом в `Kitsu-Dolphy`, красной Material 3 темой и наборами примеров для IR, HID, LAN и плагинной системы.

## Что добавлено
- переименование приложения в `Kitsu-Dolphy`
- принудительная красная тема без dynamic color
- IR-парсер для `.ir` из Flipper-IRDB
- базовые модули HID, LAN, TV cast, plugin manager
- sample `.ir` в `app/src/main/assets/Flipper-IRDB-main`

## Структура
- `app/src/main/java/com/kitsu/dolphy` — основная логика
- `app/src/main/java/com/kitsu/dolphy/ir` — IR backend
- `app/src/main/java/com/kitsu/dolphy/hid` — HID
- `app/src/main/java/com/kitsu/dolphy/network` — LAN scanner
- `app/src/main/java/com/kitsu/dolphy/tvcast` — Smart TV cast
- `app/src/main/java/com/kitsu/dolphy/plugin` — plugin manager

## Запуск
```bash
./gradlew assembleDebug
```

## Важный момент
Это не полноценная копия всего Dolphy, а рабочий каркас и конкретные файлы на русском, которые можно дальше расширять до полного функционала.
