package com.mreapps.kvissnet.gaebackend.shared;

@SuppressWarnings("UnusedDeclaration")
public class FieldVerifier
{
    public static boolean isValidName(String name, int minLength, int maxLength)
    {
        return name == null ||
                name.length() < minLength ||
                name.length() > maxLength;
    }
}
