import 'package:flutter/material.dart';

final ThemeData customTheme = ThemeData(
  primarySwatch: Colors.blue,
  //scaffoldBackgroundColor: Colors.amber,
  colorScheme:
      ColorScheme.fromSeed(seedColor: Color.fromARGB(255, 106, 177, 170)),
  textTheme: Typography.blackCupertino,
  brightness: Brightness.light,
  primaryColor: const Color.fromARGB(255, 179, 224, 230),
  useMaterial3: true,
);
