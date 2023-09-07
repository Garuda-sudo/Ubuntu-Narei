import 'package:flutter/material.dart';

final ThemeData customTheme = ThemeData(
  primarySwatch: Colors.blue,
  colorScheme:
      ColorScheme.fromSeed(seedColor: const Color.fromARGB(255, 205, 236, 233)),
  textTheme: Typography.blackCupertino,
  brightness: Brightness.light,
  primaryColor: const Color.fromARGB(255, 179, 224, 230),
  useMaterial3: true,
);
