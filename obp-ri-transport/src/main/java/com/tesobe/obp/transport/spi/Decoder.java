/*
 * Copyright (c) TESOBE Ltd. 2016. All rights reserved.
 *
 * Use of this source code is governed by a GNU AFFERO license
 * that can be found in the LICENSE file.
 *
 */
package com.tesobe.obp.transport.spi;

import com.tesobe.obp.transport.Account;
import com.tesobe.obp.transport.Bank;

import java.util.Optional;

/**
 * @since 2016.0
 */
public interface Decoder
{
  Request request(String request);

  Optional<Account> account(String response) throws DecoderException;

  Iterable<Account> accounts(String response);

  Optional<Bank> bank(String response) throws DecoderException;

  Iterable<Bank> banks(String response) throws DecoderException;

  interface Request
  {
    String raw();

    String name();

    Optional<String> accountId();

    Optional<String> bankId();

    Optional<String> transactionId();

    Optional<String> userId();
  }
}