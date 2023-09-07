import 'package:budget_buddy/accounts/account_card.dart';
import 'package:flutter/material.dart';

class AccountCarousal extends StatefulWidget {
  const AccountCarousal({super.key});

  @override
  State<AccountCarousal> createState() => _AccountCarousalState();
}

class _AccountCarousalState extends State<AccountCarousal> {
  var accounts = [
    'one',
    'two',
    'three',
    'three',
    'three',
    'three',
    'three',
    'three'
  ];

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        const SizedBox(
          height: 5.0,
        ),
        Container(
          color: Colors.white,
          padding: const EdgeInsets.fromLTRB(10.0, 5.0, 5.0, 0.0),
          child: const Text("Accounts"),
        ),
        Container(
          height: 150.0,
          color: Colors.white,
          padding: const EdgeInsets.all(2.0),
          child: ListView.builder(
              scrollDirection: Axis.horizontal,
              itemCount: accounts.length,
              itemBuilder: (BuildContext context, int index) {
                return const AccountCard();
              }),
        )
      ],
    );
  }
}
