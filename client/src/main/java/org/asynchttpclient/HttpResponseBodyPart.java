/*
 * Copyright 2010 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.asynchttpclient;

import java.nio.ByteBuffer;

/**
 * A callback class used when an HTTP response body is received.
 */
public interface HttpResponseBodyPart {

    /**
     * @return length of this part in bytes
     */
    int length();

    /**
     * @return  the response body's part bytes received.
     */
    byte[] getBodyPartBytes();

    /**
     * @return a {@link ByteBuffer} that wraps the actual bytes read from the response's chunk.
     * The {@link ByteBuffer}'s capacity is equal to the number of bytes available.
     */
    ByteBuffer getBodyByteBuffer();

    /**
     * @return true if this is the last part.
     */
    boolean isLast();

    /**
     * Close the underlying connection once the processing has completed. Invoking that method means the
     * underlying TCP connection will be closed as soon as the processing of the response is completed. That
     * means the underlying connection will never get pooled.
     */
    void markUnderlyingConnectionAsToBeClosed();

    /**
     * @return true of the underlying connection will be closed once the response has been fully processed.
     */
    boolean isUnderlyingConnectionToBeClosed();
}
